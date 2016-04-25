namespace Presentation
{
    partial class GameForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(GameForm));
            this.btnNewGame = new System.Windows.Forms.Button();
            this.lblUserWelcome = new System.Windows.Forms.Label();
            this.btnHighScores = new System.Windows.Forms.Button();
            this.btnGameHistory = new System.Windows.Forms.Button();
            this.btnLogOut = new System.Windows.Forms.Button();
            this.cbLanguage = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // btnNewGame
            // 
            resources.ApplyResources(this.btnNewGame, "btnNewGame");
            this.btnNewGame.Name = "btnNewGame";
            this.btnNewGame.UseVisualStyleBackColor = true;
            this.btnNewGame.Click += new System.EventHandler(this.btnNewGame_Click);
            // 
            // lblUserWelcome
            // 
            resources.ApplyResources(this.lblUserWelcome, "lblUserWelcome");
            this.lblUserWelcome.Name = "lblUserWelcome";
            // 
            // btnHighScores
            // 
            resources.ApplyResources(this.btnHighScores, "btnHighScores");
            this.btnHighScores.Name = "btnHighScores";
            this.btnHighScores.UseVisualStyleBackColor = true;
            this.btnHighScores.Click += new System.EventHandler(this.btnHighScores_Click);
            // 
            // btnGameHistory
            // 
            resources.ApplyResources(this.btnGameHistory, "btnGameHistory");
            this.btnGameHistory.Name = "btnGameHistory";
            this.btnGameHistory.UseVisualStyleBackColor = true;
            this.btnGameHistory.Click += new System.EventHandler(this.btnGameHistory_Click);
            // 
            // btnLogOut
            // 
            resources.ApplyResources(this.btnLogOut, "btnLogOut");
            this.btnLogOut.Name = "btnLogOut";
            this.btnLogOut.UseVisualStyleBackColor = true;
            this.btnLogOut.Click += new System.EventHandler(this.btnLogOut_Click);
            // 
            // cbLanguage
            // 
            resources.ApplyResources(this.cbLanguage, "cbLanguage");
            this.cbLanguage.FormattingEnabled = true;
            this.cbLanguage.Items.AddRange(new object[] {
            resources.GetString("cbLanguage.Items"),
            resources.GetString("cbLanguage.Items1")});
            this.cbLanguage.Name = "cbLanguage";
            this.cbLanguage.SelectedIndexChanged += new System.EventHandler(this.cbLanguage_SelectedIndexChanged);
            // 
            // GameForm
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.cbLanguage);
            this.Controls.Add(this.btnLogOut);
            this.Controls.Add(this.btnGameHistory);
            this.Controls.Add(this.btnHighScores);
            this.Controls.Add(this.lblUserWelcome);
            this.Controls.Add(this.btnNewGame);
            this.Name = "GameForm";
            this.Load += new System.EventHandler(this.GameForm_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnNewGame;
        private System.Windows.Forms.Label lblUserWelcome;
        private System.Windows.Forms.Button btnHighScores;
        private System.Windows.Forms.Button btnGameHistory;
        private System.Windows.Forms.Button btnLogOut;
        private System.Windows.Forms.ComboBox cbLanguage;
    }
}