package steps

import ResidueCollector.ResidueCollector
import pages.ResidueCollectorListPage
import pages.ResidueCollectorCreatePage
import static cucumber.api.groovy.EN.*

Given(~'^the system has no collector with CNPJ "([^"]*)"$') { String cnpj ->
    collector = ResidueCollector.findByCnpj(cnpj)
    assert collector == null
}


When(~'^I create a new collector with CNPJ "([^"]*)"$') { String cnpj ->
    CollectorTestDataAndOperations.createCollector("Nome teste",cnpj)
}

Then(~'^a collector with CNPJ "([^"]*)" is stored in the system$'){String cnpj ->
    assert ResidueCollector.findAllByCnpj(cnpj) != null
}

Given(~'^a collector with CNPJ "([^"]*)" exists in the system$'){String cnpj ->
    CollectorTestDataAndOperations.createCollector("Nome teste 2", cnpj)
    assert ResidueCollector.findAllByCnpj(cnpj) !=null
}

Then(~'^only one collector with CNPJ "([^"]*)" is stored in the system$'){String cnpj ->
    gatheredCollectors = ResidueCollector.findAllByCnpj(cnpj)
    assert gatheredCollectors != null
}

Then(~'^no collector with CNPJ "([^"]*)" is stored in the system$'){String cnpj ->
    assert ResidueCollector.findByCnpj(cnpj) == null
}

Given(~'^I am at the collector list page$'){ ->
    to ResidueCollectorListPage
    at ResidueCollectorListPage
}

When(~'^I click on the new collector button$'){->
    page.selectNewCollector()
}

Then(~'^I am at the collector creation page'){->
    to ResidueCollectorCreatePage
    at ResidueCollectorCreatePage
}

When(~'^I insert all informations correctly$'){->
    page.insertCollectorInfo()
}

When(~'^I click on the create button$'){->
    page.selectCreateCollector()
}

Then(~'^a new collector is created$'){->
    assert page.readFlashMessage() != null
}