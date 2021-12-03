fun main() {
   var PuntoA = Punto("pA",3,2)
    var PuntoB = Punto("pB",1,3)
   println(Punto.componenteDeVector(PuntoA,PuntoB))
    var listadeCordenadas = mutableListOf<Punto>(Punto("p1", -1, 0), Punto("p2",3,-1),Punto("p3",-4,4),Punto("p4",-3,2),Punto("p5",6,4),Punto("p6",-5,6),Punto("p7",10,8),Punto("p8",1,5),Punto("p9",6,-7))
    println(Punto.localizacionGeograficaNS(listadeCordenadas))
}

class Punto(var identificador: String) {
    var corX: Int = 0
    var corY: Int = 0

    constructor(identificador: String, corX: Int, corY: Int) : this(identificador) {
        this.corY = corY
        this.corX = corX
    }

    //Devuelve una instancia de la clase Pair, con las coordenadas del punto, x e y
    fun obtenerCoordenadas(): Pair<Int, Int> {
        return Pair(corY, corX)
    } // Representacion de la instancia

    override fun toString(): String {
        return "punto: $identificador, -> [<$corX>,<$corY>] "
    }
//Calcular punto restando los dos puntos
    companion object {
        fun componenteDeVector(PrimerPunto: Punto, SegundoPunto: Punto): Punto {
            var TercerPuntoID: String = PrimerPunto.identificador + SegundoPunto.identificador
            var TercerPuntoX = SegundoPunto.corX - PrimerPunto.corX
            var TercerPuntoY = SegundoPunto.corY - PrimerPunto.corY
            var TercerPunto = Punto("$TercerPuntoID, $TercerPuntoX,$TercerPuntoY")

            return TercerPunto
        }
    //Localizaciones por Norte o Sur
            fun localizacionGeograficaNS(lista: List<Punto>): Map<String, List<Punto>> {
                var Mapeo: MutableMap<String, List<Punto>> = mutableMapOf()
                var Listanorte: MutableList<Punto> = mutableListOf()
                var Listasur: MutableList<Punto> = mutableListOf()
                val Recorrer = lista.listIterator()
                for (i in Recorrer) {
                    if (i.corY >= 0) {
                        Listanorte.add(i)
                    } else {
                        Listasur.add(i)
                    }
                }
                Mapeo.put("Sur", Listasur)
                Mapeo.put("Norte", Listanorte)

                return Mapeo
            }
        }

    }



