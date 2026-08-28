package DesignPattern;

interface BonusCalculation
{
    double calculateBonus();
}

class PermanentBonus implements BonusCalculation
{
    public double calculateBonus()
    {
        return 10000;
    }
}

class ContractBonus implements BonusCalculation
{
    public double calculateBonus()
    {
        return 5000;
    }
}

class EmployeeBonusProcessor
{
    private BonusCalculation strategy;

    public EmployeeBonusProcessor(BonusCalculation strategy)
    {
        this.strategy = strategy;
    }

    public void processBonus()
    {
        System.out.println("Bonus : " + strategy.calculateBonus());
    }
}

public class HRMSBonusStrategyDemo
{
    public static void main(String[] args)
    {
        BonusCalculation strategy = new PermanentBonus();

        EmployeeBonusProcessor processor =
                new EmployeeBonusProcessor(strategy);

        processor.processBonus();
    }
}
