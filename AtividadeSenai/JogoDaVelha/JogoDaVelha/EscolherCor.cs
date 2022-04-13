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
    public partial class EscolherCor : Form
    {
        int valor1, valor2, valor3;
        public EscolherCor()
        {
            InitializeComponent();
        }

        private void bt_sair_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void trackBar3_Scroll_1(object sender, EventArgs e)
        {
            valor1 = trackBar1.Value * 20;
            valor2 = trackBar2.Value * 20;
            valor3 = trackBar3.Value * 20;
            pictureBox1.BackColor = Color.FromArgb(valor1, valor2, valor3);
        }

    }
}
