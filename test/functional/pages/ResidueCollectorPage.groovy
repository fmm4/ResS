package pages

import geb.Page
import steps.CollectorTestDataAndOperations

class ResidueCollectorListPage extends Page {
        def titulo = "ResidueCollector List"
        static url = "/ResS/residueCollector/list"

        static at = {

            title ==~ titulo
        }

        def selectNewCollector(){
            $("input", name: "New ResidueCollector").click()
        }

}

class ResidueCollectorCreatePage extends Page{
    def titulo = "Create ResidueCollector"
    static url = "/ResS/residueCollector/create"

    static at = {
        title ==~ titulo
    }

    def insertCollectorInfo(){
        $("form").collectorName = "Petrobras"
        $("form").cnpj = "53.406.847/0001-37"
    }

    def selectCreateCollector(){
        $("input", name: "create").click()
    }

}