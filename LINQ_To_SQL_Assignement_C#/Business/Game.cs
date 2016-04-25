using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Text;
using System.Threading.Tasks;

namespace Business
{
    [Table]
    public class Game
    {
        [Column(IsPrimaryKey = true, IsDbGenerated = true)]
        public int Id;
        [Column]
        public int Score;

        private EntitySet<Question> _questions = new EntitySet<Question>();

        [Association(Storage = "_questions", OtherKey = "Game_Id", ThisKey = "Id")]
        public ICollection<Question> quizes
        {
            get { return _questions; }
            set { _questions.Assign(value); }
        }

        // Foreign Restraint.
        private EntityRef<User> _user = new EntityRef<User>();
        [Column]
        public int User_Id;
        [Association(IsForeignKey = true, Storage = "_user", ThisKey = "User_Id")]
        public User user
        {
            get { return _user.Entity; }
            set { _user.Entity = value; }
        }
    }
}
