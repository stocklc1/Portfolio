using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Resources;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Presentation
{
    public partial class GameForm : Form
    {
        ComponentResourceManager resources;
        ResourceManager rm;
        public GameForm()
        {
            InitializeComponent();
        }

        private void btnLogOut_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void GameForm_Load(object sender, EventArgs e)
        {
           resources = new ComponentResourceManager(typeof(GameForm));
           rm = new ResourceManager("Presentation.GameForm", typeof(GameForm).Assembly);
           cbLanguage.SelectedIndex = 0;
           lblUserWelcome.Text =  "Welcome " + UserLogin.loggedInUser.UserName;
        }

        private void btnNewGame_Click(object sender, EventArgs e)
        {
            TrivaGameForm tform = new TrivaGameForm();
            tform.Show();
        }

        private void btnGameHistory_Click(object sender, EventArgs e)
        {
            GameHistory ghForm = new GameHistory();
            ghForm.Show();
        }

        private void btnHighScores_Click(object sender, EventArgs e)
        {
            HighScores hsForm = new HighScores();
            hsForm.Show();
        }

        private void cbLanguage_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbLanguage.Text == "French")
            {
                Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo("fr");
            }
            else if (cbLanguage.Text == "English")
            {
                Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo("en");
            }
            resources.ApplyResources(btnNewGame, btnNewGame.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnGameHistory, btnGameHistory.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnHighScores, btnHighScores.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnLogOut, btnLogOut.Name, Thread.CurrentThread.CurrentUICulture);
        }

    }
}
