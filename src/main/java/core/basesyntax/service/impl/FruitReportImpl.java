package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReport;
import core.basesyntax.service.FruitService;
import java.util.List;

public class FruitReportImpl implements FruitReport {
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final FruitService fruitService = new FruitServiceImpl(fruitDao);

    @Override
    public String getReport() {
        List<Fruit> fruits = fruitService.getAll();
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Fruit fruit : fruits) {
            report.append(System.lineSeparator()).append(fruit.getName())
                    .append(",").append(fruit.getAmount());
        }
        return report.toString();
    }
}