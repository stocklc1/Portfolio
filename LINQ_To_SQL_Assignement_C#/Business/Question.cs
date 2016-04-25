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
    public class Question
    {
        [Column(IsPrimaryKey = true, IsDbGenerated = true)]
        public int Id;
        [Column]
        public string Text;
        [Column]
        public string Answer;
        [Column]
        public string Hint;

        // Foreign Restraint.
        private EntityRef<Game> _game = new EntityRef<Game>();
        [Column]
        public int? Game_Id;
        [Association(IsForeignKey = true, Storage = "_game", ThisKey = "Game_Id")]
        public Game game
        {
            get { return _game.Entity; }
            set { _game.Entity = value; }
        }
    }
}
