using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace JogoDaVelha
{
    public partial class JogoSimples : Form
    {
        public JogoSimples()
        {
            InitializeComponent();
        }

        private void jogoNormal_Click(object sender, EventArgs e)
        {
        }

        private void jogoNormal_Paint(object sender, PaintEventArgs e)
        {
            Pen pen = new Pen(Color.Black, 2);
            
            Graphics g = e.Graphics;
            g.DrawLine(pen, 100, jogoNormal.Width/5 + 100, jogoNormal.Width - 100, jogoNormal.Width/5 + 100);
            g.DrawLine(pen, 100, jogoNormal.Width / 5 + 200, jogoNormal.Width - 100, jogoNormal.Width / 5 + 200);
            g.DrawLine(pen, jogoNormal.Width / 5 + 100, 100, jogoNormal.Width / 5 + 100, jogoNormal.Width - 100);
            g.DrawLine(pen, jogoNormal.Width / 5 + 200, 100, jogoNormal.Width / 5 + 200, jogoNormal.Width - 100);
        }

        private void bt_sair_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
