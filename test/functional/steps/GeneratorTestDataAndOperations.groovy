package steps

import residueGenerator.ResidueGenerator
import residueGenerator.ResidueGeneratorController

class GeneratorTestDataAndOperations{

    static  generators = [

            [nameGenerator:"RU",
             type: "Restaurante",
             cnpj: "testecnpj1",
             addressGenerator: "Bubble Street number 7",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"Clovis Palace",
             type: "Restaurante",
             cnpj: "testecnpj2",
             addressGenerator: "Bubble Street number 4",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

    ]

    static public def getGenerator(){
        return findGeneratorByAddress("Bubble Street number 7")
    }

    static public def findGeneratorByAddress(String address) {
        generators.find { generator ->
            generator.addressGenerator == address
        }
    }

    static public void createGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void editGenerator(String address, def residueGenerator){
        def cont = new ResidueGeneratorController()
        cont.params << [name: "Clovis Palace"] << [type: "Restaurante"] << [cnpj:"testecnpj2" ] << [addressGenerator:address ] << [averageMonthlyMeals: 0] << [averageDailyMeals:0] << [id: residueGenerator.getId()]
        cont.edit()
        cont.save()
        cont.response.reset()
    }



    //LIST FEATURES
    static public void createGeneratorWithDailyMeal(String address, int dailymeal){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress("Bubble Street number 7")
        cont.params << novoGenerator
        cont.params << [addressGenerator: address] << [averageDailyMeals: dailymeal]
        cont.create()
        cont.save()
        cont.response.reset()
    }


    static public boolean containResidueGenerator(String address,ResGen){
        def testresidue = ResidueGenerator.findByAddressGenerator(address)
        return ResGen.contains(testresidue)
    }

    static public boolean isSorted(Residuegenerators) {
        //def isSorted = (Residuegenerators.size() < 2 || (1..<Residuegenerators.size()).every { (Residuegenerators[it - 1].averageDailyMeals).compareTo(Residuegenerators[it].averageDailyMeals) > 0})
        def isSorted = ResidueGenerator.findAll().sort{it.averageDailyMeals}
        isSorted = isSorted.reverse()
        return ((isSorted[0].addressGenerator).equals(Residuegenerators[0].addressGenerator) && (isSorted[1].addressGenerator).equals(Residuegenerators[1].addressGenerator))
    }
    ///////


}