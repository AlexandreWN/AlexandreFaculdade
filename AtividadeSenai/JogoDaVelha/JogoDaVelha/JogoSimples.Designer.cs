namespace JogoDaVelha
{
    partial class JogoSimples
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
            this.jogoNormal = new System.Windows.Forms.PictureBox();
            this.bt_sair = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.jogoNormal)).BeginInit();
            this.SuspendLayout();
            // 
            // jogoNormal
            // 
            this.jogoNormal.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.jogoNormal.Location = new System.Drawing.Point(34, 31);
            this.jogoNormal.Name = "jogoNormal";
            this.jogoNormal.Size = new System.Drawing.Size(500, 500);
            this.jogoNormal.TabIndex = 0;
            this.jogoNormal.TabStop = false;
            this.jogoNormal.Click += new System.EventHandler(this.jogoNormal_Click);
            this.jogoNormal.Paint += new System.Windows.Forms.PaintEventHandler(this.jogoNormal_Paint);
            // 
            // bt_sair
            // 
            this.bt_sair.BackColor = System.Drawing.Color.Red;
            this.bt_sair.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_sair.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.bt_sair.ForeColor = System.Drawing.Color.White;
            this.bt_sair.Location = new System.Drawing.Point(563, 12);
            this.bt_sair.Name = "bt_sair";
            this.bt_sair.Size = new System.Drawing.Size(27, 28);
            this.bt_sair.TabIndex = 2;
            this.bt_sair.Text = "X";
            this.bt_sair.UseVisualStyleBackColor = false;
            this.bt_sair.Click += new System.EventHandler(this.bt_sair_Click);
            // 
            // JogoSimples
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(602, 558);
            this.Controls.Add(this.bt_sair);
            this.Controls.Add(this.jogoNormal);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "JogoSimples";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "JogoSimples";
            ((System.ComponentModel.ISupportInitialize)(this.jogoNormal)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox jogoNormal;
        private System.Windows.Forms.Button bt_sair;
    }
}