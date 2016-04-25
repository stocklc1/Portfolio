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
    public class User
    {
        [Column(IsPrimaryKey = true, IsDbGenerated = true)]
        public int Id;
        [Column]
        public string UserName;
        [Column]
        public string Password;

        private EntitySet<Game> _games = new EntitySet<Game>();

        [Association(Storage = "_games", OtherKey = "User_Id", ThisKey = "Id")]
        public ICollection<Game> games
        {
            get { return _games; }
            set { _games.Assign(value); }
        }
    }
}
