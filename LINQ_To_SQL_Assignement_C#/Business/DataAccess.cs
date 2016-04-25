using System;
using System.Collections.Generic;
using System.Data.Linq.Mapping;
using System.Data.Linq;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business
{
    public class DataAccess
    {
        private Random random = new Random();

        private static TriviaGame tGame;
        [Database]
        private class TriviaGame : DataContext
        {
            public TriviaGame()
                : base("Data Source=(localdb)\\Projects;"
                    + "AttachDbFilename=|DataDirectory|\\TriviaGame.mdf;" +
                    "Initial Catalog=TriviaGame;Integrated Security=True"){
            }

            public Table<User> User;
            public Table<Game> Game;
            public Table<Question> Question;
        }

        public void DBConnect()
        {
            AppDomain currentDomain = AppDomain.CurrentDomain;
            currentDomain.SetData("DataDirectory", "E:\\Year 2\\Semester 2\\Windows Programming C#\\Projects\\CSharpProject");
            tGame = new TriviaGame();
        }

        public void AddToUser(User user)
        {
            if (tGame.GetTable<User>().Count() == 0)
                tGame.User.Context.ExecuteCommand("DBCC CHECKIDENT('User', RESEED, 0);");

            tGame.GetTable<User>().InsertOnSubmit(user);
            tGame.SubmitChanges();
        }

        public User GetUserByGame(Game game)
        {
            IEnumerable<User> users = from d in tGame.User
                                      where d.Id == game.User_Id
                                      orderby d.Id descending
                                      select d;

            foreach (User user in users)
            {
                return user;
            }

            return null;
        }

        public bool CheckIfUserExists(string username)
        {
            IEnumerable<User> users = from d in tGame.User
                                    orderby d.Id descending
                                    select d;

            foreach (User user in users)
            {
                if (user.UserName == username)
                {
                    return true;
                }
            }

            return false;
        }

        public User LogIntoUser(string username)
        {
            IEnumerable<User> users = from d in tGame.User
                                      orderby d.Id descending
                                      select d;

            foreach (User user in users)
            {
                if (user.UserName == username)
                {
                    return user;
                }
            }

            return null;
        }

        public IEnumerable<Question> RandomizeQuestions()
        {
            IEnumerable<Question> questions = from d in tGame.Question
                                              where d.Game_Id == null
                                              orderby d.Id descending
                                              select d;

            questions = questions.OrderBy(order => random.Next()).ToList();

            return questions;
        }

        public void AddToGame(Game game)
        {
            if (tGame.GetTable<Game>().Count() == 0)
                tGame.Game.Context.ExecuteCommand("DBCC CHECKIDENT('Game', RESEED, 0);");

            tGame.GetTable<Game>().InsertOnSubmit(game);
            tGame.SubmitChanges();
        }

        public IEnumerable<Game> GetGameHistory(User user)
        {
            IEnumerable<Game> games = from d in tGame.Game
                                              where d.User_Id == user.Id
                                              orderby d.Id descending
                                              select d;

            if (games != null)
                return games;
            else
                return null;
        }

        public IEnumerable<Game> GetGamesOrderdByScored()
        {
            IEnumerable<Game> games = from d in tGame.Game
                                      orderby d.Score descending
                                      select d;

            if (games != null)
                return games;
            else
                return null;
        }

        public void AddToQuestion(Question question)
        {
            if (tGame.GetTable<Question>().Count() == 0)
                tGame.Question.Context.ExecuteCommand("DBCC CHECKIDENT('Question', RESEED, 0);");

            tGame.GetTable<Question>().InsertOnSubmit(question);
            tGame.SubmitChanges();
        }
    }
}
