

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.seuprojeto.banco.Conta.sacar(..))")
    public void saque() {}

    @Before("saque()")
    public void beforeSaque(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        double valor = (double) args[0];
        Conta conta = (Conta) joinPoint.getTarget();
        System.out.println("Tentando sacar " + valor + " da conta com saldo: " + conta.getSaldo());
    }

    @AfterReturning(pointcut = "saque()", returning = "result")
    public void afterSaque(JoinPoint joinPoint, boolean result) {
        if (!result) {
            Conta conta = (Conta) joinPoint.getTarget();
            System.out.println("Saldo insuficiente na conta com saldo: " + conta.getSaldo());
        }
    }
}
