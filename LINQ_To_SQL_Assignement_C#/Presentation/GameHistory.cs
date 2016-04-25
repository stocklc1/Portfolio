using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Business;

namespace Presentation
{
    public partial class GameHistory : Form
    {
        public GameHistory()
        {
            InitializeComponent();
        }

        private void GameHistory_Load(object sender, EventArgs e)
        {
            IEnumerable<Game> userGames = UserLogin.da.GetGameHistory(UserLogin.loggedInUser);

            foreach(Game game in userGames)
            {
                tbHistory.Text += "Username: " + UserLogin.loggedInUser.UserName + " Score: " + game.Score + "\r\n";
            }
        }
    }
}
