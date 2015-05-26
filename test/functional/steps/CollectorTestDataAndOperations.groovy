package steps

import ResidueCollector.ResidueCollector
import ResidueCollector.ResidueCollectorController

class CollectorTestDataAndOperations {

    static collectors = [
            [name: "Petrobras", cnpj:"53.406.847/0001-37"],
            [name: "Ong Trevo", cnpj:"11.353.973/0001-20"]
    ]
        static public void createCollector(String Cname, String CCNPJ){
            def cont = new ResidueCollectorController()
            cont.params << [name: Cname] << [cnpj: CCNPJ]
            cont.create()
            cont.save()
            cont.response.reset()
        }


    static public def getCollector(){
        def cont = new ResidueCollectorController()
        cont.params << collectors.get(0)
        cont.create()
        cont.save()
        cont.response.reset()
        return ResidueCollector.findByCnpj("53.406.847/0001-37")
    }


}
