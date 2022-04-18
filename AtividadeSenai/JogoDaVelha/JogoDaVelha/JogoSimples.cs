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
        string a = "";
        List<string> jog1 = new List<string>();
        List<string> jog2 = new List<string>();
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
                if (jog2.Contains(pb.Name[pb.Name.Length -1].ToString()) == false && jog1.Contains(pb.Name[pb.Name.Length -1].ToString()) == false)
                {
                    g.DrawLine(pen, pb.Width - 20, pb.Height -20, pb.Width -80, pb.Height -80);
                    g.DrawLine(pen, pb.Width - 20, pb.Height - 80, pb.Width - 80, pb.Height - 20);

                    pb.Image = bitmap;
                    jog1.Add(pb.Name[pb.Name.Length -1].ToString());
                    vez = 1;

                    if(jog1.Contains("1") && jog1.Contains("2") && jog1.Contains("3") || jog1.Contains("4") && jog1.Contains("5") && jog1.Contains("6") || jog1.Contains("7") && jog1.Contains("8") && jog1.Contains("9") || jog1.Contains("1") && jog1.Contains("4") && jog1.Contains("7") || jog1.Contains("2") && jog1.Contains("5") && jog1.Contains("8") || jog1.Contains("3") && jog1.Contains("6") && jog1.Contains("9") || jog1.Contains("1") && jog1.Contains("5") && jog1.Contains("9") || jog1.Contains("3") && jog1.Contains("5") && jog1.Contains("7"))
                    {
                        MessageBox.Show("jogaqdor 1 venceu");
                    }
                }
                else
                {
                    MessageBox.Show("campo ja selecionado");
                }
            }
            else
            {
                Pen pen = new Pen(Color.FromArgb(r2, g2, b2), 7);
                var pb = sender as PictureBox;

                Bitmap bitmap = new Bitmap(pb.Width, pb.Height);
                Graphics g = Graphics.FromImage(bitmap);
                if (jog2.Contains(pb.Name[pb.Name.Length -1].ToString()) == false && jog1.Contains(pb.Name[pb.Name.Length -1].ToString()) == false)
                {
                    g.DrawEllipse(pen, pb.Width / 2 - 70 / 2, pb.Height / 2 - 70 / 2, 70, 70);
                    pb.Image = bitmap;
                    jog2.Add(pb.Name[pb.Name.Length -1].ToString());
                    vez = 0;
                    if (jog2.Contains("1") && jog2.Contains("2") && jog2.Contains("3") || jog2.Contains("4") && jog2.Contains("5") && jog2.Contains("6") || jog2.Contains("7") && jog2.Contains("8") && jog2.Contains("9") || jog2.Contains("1") && jog2.Contains("4") && jog2.Contains("7") || jog2.Contains("2") && jog2.Contains("5") && jog2.Contains("8") || jog2.Contains("3") && jog2.Contains("6") && jog2.Contains("9") || jog2.Contains("1") && jog2.Contains("5") && jog2.Contains("9") || jog2.Contains("3") && jog2.Contains("5") && jog2.Contains("7"))
                    {
                        MessageBox.Show("jogaqdor 2 venceu");
                    }
                }
                else
                {
                    MessageBox.Show("campo ja selecionado");
                }
            }
            
        }
    }
}
