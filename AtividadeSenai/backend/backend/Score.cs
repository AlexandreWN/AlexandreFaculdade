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
    
    public partial class Score
    {
        public int id { get; set; }
        public Nullable<int> score1 { get; set; }
        public int user_id { get; set; }
        public int jogo_id { get; set; }
    
        public virtual Jogo Jogo { get; set; }
        public virtual Usuario Usuario { get; set; }
    }
}
