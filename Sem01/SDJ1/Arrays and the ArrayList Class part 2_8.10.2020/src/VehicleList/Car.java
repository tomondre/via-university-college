package VehicleList;

public class Car
{
  private Engine engine;
  private String make,model;
  private boolean manualGear;
  public Car(String make, String model)
  {
    this.make = make;
    this.model = model;
  }

  public Engine getEngine()
  {
    return engine;
  }

  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public boolean hasManualGear()
  {
    return manualGear;
  }

  public void setEngine(Engine engine)
  {
    this.engine = engine;
  }

  @Override public String toString()
  {
    return "engine=" + engine + ", make='" + make + '\'' + ", model='"
        + model + '\'' + ", manualGear='" + manualGear + '\'' + '}';
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Car)){
      return false;
    }
    Car other = (Car)obj;
    return engine==null?manualGear==other.manualGear&&make.equals(other.make)&&
        model.equals(other.model):manualGear==other.manualGear&&
        make.equals(other.make)&&model.equals(other.model)&&
        engine.equals(other.engine);
  }
}
