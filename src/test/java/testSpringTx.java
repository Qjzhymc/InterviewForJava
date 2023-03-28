import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class testSpringTx {
    /*
    1. 使用TransactionTemplate进行编程式事务管理的示例代码
     */
    @Autowired
    private TransactionTemplate transactionTemplate;
    public void testTransaction1() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    //业务代码
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });
    }

    /*
    2. 使用TransactionManager进行编程式事务管理的示例代码
     */
    @Autowired
    private PlatformTransactionManager transactionManager;
    public void testTransaction2() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            //业务代码
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        }
    }

}
