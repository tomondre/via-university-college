namespace Person
{
    public class User : Adult
    {
        public string Password { get; set; }
        public string UserName { get; set; }
        public string SecurityType { get; set; }

        public User()
        {
        }   

        public User(Adult adult)
        {
            Id = adult.Id;
            Age = adult.Age;
            Height = adult.Height;
            Id = adult.Id;
            Sex = adult.Sex;
            Weight = adult.Weight;
            EyeColor = adult.EyeColor;
            FirstName = adult.FirstName;
            HairColor = adult.HairColor;
            JobTitle = adult.JobTitle;
            LastName = adult.LastName;
        }
    }
}