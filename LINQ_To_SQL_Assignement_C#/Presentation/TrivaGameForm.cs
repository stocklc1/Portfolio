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
using System.Resources;
using System.Threading;
using System.Globalization;

namespace Presentation
{
    public partial class TrivaGameForm : Form
    {
        ComponentResourceManager resources;
        ResourceManager rm;
        public IEnumerable<Question> questions;
        public int questionNum = 0;
        public int score = 0;
        public TrivaGameForm()
        {
            InitializeComponent();
        }

        private void TrivaGameForm_Load(object sender, EventArgs e)
        {
            resources = new ComponentResourceManager(typeof(GameForm));
            rm = new ResourceManager("Presentation.GameForm", typeof(GameForm).Assembly);
            cbLanguage.SelectedIndex = 0;
            questions = UserLogin.da.RandomizeQuestions();
            lblQuestion.Text = questions.ElementAt(questionNum).Text;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            tbAnswer.Text = "";

            if (questionNum < questions.Count() && questions.ElementAt(questionNum).Answer.ToLower() == tbAnswer.Text.ToLower())
            {
                score++;
                MessageBox.Show("You Are Correct!!");
            }
            else
                MessageBox.Show("You Are Incorrect!!");

            questionNum++;
            if (questionNum < questions.Count())
                lblQuestion.Text = questions.ElementAt(questionNum).Text;
            else
            {
                MessageBox.Show("Game Over. Your Score Was " + score + "/" + questions.Count());
                Game newGame = new Game();
                newGame.Score = score;
                newGame.User_Id = UserLogin.loggedInUser.Id;
                UserLogin.da.AddToGame(newGame);
                this.Close();
            }
        }

        private void btnHint_Click(object sender, EventArgs e)
        {
            lblHint.Text = "Hint: " + questions.ElementAt(questionNum).Hint;
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
            resources.ApplyResources(btnHint, btnHint.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnGuess, btnGuess.Name, Thread.CurrentThread.CurrentUICulture);
        }
    }
}
