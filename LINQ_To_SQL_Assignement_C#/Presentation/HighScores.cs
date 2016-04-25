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
    public partial class HighScores : Form
    {
        public HighScores()
        {
            InitializeComponent();
        }

        private void HighScores_Load(object sender, EventArgs e)
        {
            IEnumerable<Game> highScores = UserLogin.da.GetGamesOrderdByScored();

            foreach(Game game in highScores)
            {
                tbHighScores.Text += "Username: " + UserLogin.da.GetUserByGame(game).UserName + " Score: " + game.Score + "\r\n";
            }
        }
    }
}
