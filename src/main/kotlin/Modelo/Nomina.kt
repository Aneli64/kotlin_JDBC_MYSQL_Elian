package Modelo

class Nomina(var nomb_emp: String = "",
             var ape_emp: String = "",
             var n_emp: Int = 0,
             var sal_base: Double = 0.0,
             var hs_trab: Int = 0,
             var deducc: Double = 0.0,
             var fech_pag: String = "")
{
    override fun toString(): String {
        return "Modelo.Nomina(nomb_emp='$nomb_emp', ape_emp='$ape_emp', n_emp=$n_emp, sal_base=$sal_base, hs_trab=$hs_trab, deducc=$deducc, fech_pag='$fech_pag')"
    }

}