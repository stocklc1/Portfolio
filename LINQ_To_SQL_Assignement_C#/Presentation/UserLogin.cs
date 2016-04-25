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
using System.Threading;
using System.Globalization;
using System.Resources;

namespace Presentation
{
    public partial class UserLogin : Form
    {
        public static DataAccess da = new DataAccess();
        public static User loggedInUser;
        ComponentResourceManager resources;
        ResourceManager rm;

        public UserLogin()
        {
            InitializeComponent();
        }

        private void UserLogin_Load(object sender, EventArgs e)
        {
            resources = new ComponentResourceManager(typeof(UserLogin));
            rm = new ResourceManager("Presentation.UserLogin", typeof(UserLogin).Assembly);
            cbLanguage.SelectedIndex = 0;
            da.DBConnect();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            loggedInUser = da.LogIntoUser(tbUsername.Text);
            if (loggedInUser != null)
            {
                if (loggedInUser.Password == tbPassword.Text)
                {
                    tbPassword.Text = "";
                    tbUsername.Text = "";
                    GameForm gf = new GameForm();
                    gf.Show();
                }
                else
                    MessageBox.Show("Password Incorrect.");
            }
            else
                MessageBox.Show("User Doesn't Exist.");
        }

        private void btnCreateUser_Click(object sender, EventArgs e)
        {
            if (!da.CheckIfUserExists(tbUsername.Text))
            {
                User newUser = new User();
                newUser.UserName = tbUsername.Text;
                newUser.Password = tbPassword.Text;
                da.AddToUser(newUser);
                tbPassword.Text = "";
                tbUsername.Text = "";
                MessageBox.Show("User Created.");
            }
            else
            {
                tbPassword.Text = "";
                tbUsername.Text = "";
                MessageBox.Show("User Alread Exists.");
            }
        }

        private void cbLanguage_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(cbLanguage.Text == "French")
            {
                Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo("fr");
            }
            else if (cbLanguage.Text == "English")
            {
                Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo("en");
            }
            resources.ApplyResources(lblUsername, lblUsername.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(lblPassword, lblPassword.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnLogin, btnLogin.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnCreateUser, btnCreateUser.Name, Thread.CurrentThread.CurrentUICulture);
            resources.ApplyResources(btnExit, btnExit.Name, Thread.CurrentThread.CurrentUICulture);
        }

    }
}
