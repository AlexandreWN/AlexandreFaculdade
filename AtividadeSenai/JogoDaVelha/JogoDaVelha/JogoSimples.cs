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
        int contador = 0;
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

            Pen pen = new Pen(Color.Black, 2);

            Graphics g = e.Graphics;
            g.DrawLine(pen, 100, pictureBox6.Width / 5 + 100, pictureBox6.Width - 100, pictureBox6.Width / 5 + 100);
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
            
            if(contador != 0)
            {
                if (ComparaImagem(pictureBox1.Image, pictureBox6.Image, pictureBox9.Image))
                {
                    MessageBox.Show("As imagens são iguais.");
                }
                else
                {
                    MessageBox.Show("As imagens são diferentes.");
                }
            }
            contador++;
            
        }
        
        private bool ComparaPixels(Bitmap imagem1, Bitmap imagem2, Bitmap imagem3)
        {
            for (int x = 0; x < imagem1.Width; x++)
            {
                for (int y = 0; y < imagem1.Height; y++)
                {
                    if (imagem1.GetPixel(x, y) != imagem2.GetPixel(x, y) || imagem1.GetPixel(x, y) != imagem3.GetPixel(x, y))
                    {
                        return false;
                    }
                }
            }

            return true;
        }
        private bool ComparaImagem(Image imagem1, Image imagem2, Image imagem3)
        {
            using (var bitmap1 = new Bitmap(imagem1))
            using (var bitmap2 = new Bitmap(imagem2))
            using (var bitmap3 = new Bitmap(imagem3))
            {
                return ComparaPixels(bitmap1, bitmap2, bitmap3);
            }
        }
    }
}
