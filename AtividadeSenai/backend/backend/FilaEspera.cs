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
    
    public partial class FilaEspera
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public FilaEspera()
        {
            this.Partida = new HashSet<Partida>();
        }
    
        public int id { get; set; }
        public byte[] dataFila { get; set; }
        public int user_id { get; set; }
        public int jogo_id { get; set; }
    
        public virtual Jogo Jogo { get; set; }
        public virtual Usuario Usuario { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Partida> Partida { get; set; }
    }
}
