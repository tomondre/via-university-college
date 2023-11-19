# Resulting Table

| Input Size | Filter Size | CPU time (ms) | GPU time (ms) | Speedup |
|:----------:|:-----------:|:-------------:|:-------------:|:-------:| 
| 512 | 4 | 50.232728 | 0.770472 | 65.17 | 
| 512 | 2 | 7.702594 | 0.446425 | 17.25 | 
| 256 | 4 | 5.168102 | 0.136153 | 37.92 | 
| 256 | 2 | 0.806271 | 0.056447 | 14.29 | 
| 128 | 4 | 0.639956 | 0.017192 | 37.20 | 
| 128 | 2 | 0.194494 | 0.008280 | 23.49 |

# Resulting Graph
![[Pasted image 20230624113205.png]]

# Analysis
* The execution time for the GPU was significantly less than the CPU, a result of the GPU's ability to leverage parallelism and thus achieve a higher throughput than the CPU. Consequently, the CPU tends to lag behind when it comes to handling larger tasks.
- The speedup observed with smaller input sizes was not as significant. This might be attributed to the GPU's initialisation time for spinning up all processes and threads, which can be excessive for relatively smaller tasks
- The filter size has a considerable impact on the execution times. As the number of filters increases, so does the execution time

# Code
```C
#include <stdio.h>

__global__ void direct_convolution(float * in, float * k, float * out, int i_s, int k_s, int o_s) {
  int i = blockIdx.x * blockDim.x + threadIdx.x;
  int j = blockIdx.y * blockDim.y + threadIdx.y;
  int k = blockIdx.z * blockDim.z + threadIdx.z;
  if (i < o_s && j < o_s && k < o_s) {
    float sum = 0;
    for (int l = 0; l < k_s; l++)
      for (int m = 0; m < k_s; m++)
        for (int n = 0; n < k_s; n++)
          sum += in[(i + l) * i_s * i_s + (j + m) * i_s + (k + n)] * k[l * k_s * k_s + m * k_s + n];
    out[i * o_s * o_s + j * o_s + k] = sum;
  }
}

void direct_convolution_cpu(float *in, float *k, float *out, int i_s, int k_s, int o_s){
  for (int i = 0; i < o_s; i++)
    for (int j = 0; j < o_s; j++)
      for (int k = 0; k < o_s; k++) {
        float sum = 0;
        for (int l = 0; l < k_s; l++)
          for (int m = 0; m < k_s; m++)
            for (int n = 0; n < k_s; n++)
              sum += in[(i + l) * i_s * i_s + (j + m) * i_s + (k + n)] * k[l * k_s * k_s + m * k_s + n];
        out[i * o_s * o_s + j * o_s + k] = sum;
      }
}

int main(int argc, char * argv[]) {
  int i_s = atoi(argv[1]), k_s = atoi(argv[2]), o_s = i_s - k_s + 1;
  int i_s_b = i_s * i_s * i_s * sizeof(float), k_s_b = k_s * k_s * k_s * sizeof(float), o_s_b = o_s * o_s * o_s * sizeof(float);

  float * in = (float * ) malloc(i_s_b), * k = (float * ) malloc(k_s_b), * out = (float * ) malloc(o_s_b);

  for (int i = 0; i < i_s * i_s * i_s; i++) in[i] = (float)(rand() % 100) / 100;
  for (int i = 0; i < k_s * k_s * k_s; i++) k[i] = (float)(rand() % 100) / 100;
  for (int i = 0; i < o_s * o_s * o_s; i++) out[i] = 0;

  float s_time = clock();
  direct_convolution_cpu(in, k, out, i_s, k_s, o_s);
  printf("CPU time: %f\n", (double)(clock() - s_time) / CLOCKS_PER_SEC);

  cudaDeviceSynchronize();
  s_time = clock();

  float * d_in, * d_k, * d_out;
  cudaMalloc(&d_in, i_s_b);
  cudaMalloc(&d_k, k_s_b);
  cudaMalloc(&d_out, o_s_b);

  cudaMemcpy(d_in, in, i_s_b, cudaMemcpyHostToDevice);
  cudaMemcpy(d_k, k, k_s_b, cudaMemcpyHostToDevice);
  cudaMemcpy(d_out, out, o_s_b, cudaMemcpyHostToDevice);

  dim3 block_size(8, 8, 8);
  dim3 grid_size((o_s + block_size.x - 1) / block_size.x, (o_s + block_size.y - 1) / block_size.y, (o_s + block_size.z - 1) / block_size.z);
  direct_convolution<<<grid_size, block_size>>>(d_in, d_k, d_out, i_s, k_s, o_s);

  cudaMemcpy(out, d_out, o_s_b, cudaMemcpyDeviceToHost);
  
  cudaDeviceSynchronize();
  printf("GPU time: %f\n", (double)(clock() - s_time) / CLOCKS_PER_SEC);

  free(in);
  free(k);
  free(out);
  cudaFree(d_in);
  cudaFree(d_k);
  cudaFree(d_out);
  return 0;
}
```