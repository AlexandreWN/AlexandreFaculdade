//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace backend
{
    using System;
    using System.Collections.Generic;
    
    public partial class Tabuleiro
    {
        public int id { get; set; }
        public Nullable<int> casa { get; set; }
        public string jogada { get; set; }
        public int partida_id { get; set; }
    
        public virtual Partida Partida { get; set; }
    }
}