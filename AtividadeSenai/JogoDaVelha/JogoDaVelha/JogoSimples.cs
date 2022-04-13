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
        int vez = 0;
        int r1 = 0, g1 = 0, b1 = 0;
        int r2 = 222, g2 = 222, b2 = 222;
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

        private void pictureBox6_Paint(object sender, PaintEventArgs e)
        {
        }

        private void JogoSimples_MouseClick(object sender, MouseEventArgs e)
        {
            if(vez == 0)
            {
                Pen pen = new Pen(Color.FromArgb(r1,g1,b1),7);
                var pb = sender as PictureBox;

                Bitmap bitmap = new Bitmap(pb.Width, pb.Height);
                Graphics g = Graphics.FromImage(bitmap);

                g.DrawLine(pen,pb.Width - 20, pb.Height -20, pb.Width -80, pb.Height -80);
                g.DrawLine(pen, pb.Width - 20, pb.Height - 80, pb.Width - 80, pb.Height - 20);

                pb.Image = bitmap;
                vez = 1;
            }
            else
            {
                Pen pen = new Pen(Color.FromArgb(r2, g2, b2), 7);
                var pb = sender as PictureBox;

                Bitmap bitmap = new Bitmap(pb.Width, pb.Height);
                Graphics g = Graphics.FromImage(bitmap);

                g.DrawEllipse(pen, pb.Width / 2 - 70 / 2, pb.Height / 2 - 70 / 2, 70, 70);

                pb.Image = bitmap;
                vez = 0;
            }
        }
    }
}
