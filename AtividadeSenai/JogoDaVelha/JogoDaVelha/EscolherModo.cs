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
    public partial class EscolherModo : Form
    {
        public EscolherModo()
        {
            InitializeComponent();
        }

        private void bt_sair_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bt_offSimples_Click(object sender, EventArgs e)
        {
            JogoSimples novo = new JogoSimples();
            novo.Show();
            this.Close();
        }

        private void bt_login_Click(object sender, EventArgs e)
        {

        }
    }
}
