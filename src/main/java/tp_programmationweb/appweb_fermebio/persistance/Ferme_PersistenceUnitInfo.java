package tp_programmationweb.appweb_fermebio.persistance;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Ferme_PersistenceUnitInfo implements PersistenceUnitInfo {
    @Override
    public String getPersistenceUnitName() {
        return "Ferme_PersistenceUnitInfo";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {

        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> managedClassNames = new ArrayList<>();
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.Client");
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.LigneCommande");
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.Commande");
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.Produit");
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.Message");
        managedClassNames.add("tp_programmationweb.appweb_fermebio.modele.ProduitTraduction");
        return managedClassNames;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.format_sql","false");
        properties.setProperty("hibernate.use_sql_comments","false");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.ejb.interceptor","org.hibernate.ejb.interceptor.EmptyInterceptor");

        properties.setProperty("javax.persistence.jdbc.driver","org.mariadb.jdbc.Driver");
        properties.setProperty("javax.persistence.jdbc.url","jdbc:mariadb://mysql-fatmaa10.alwaysdata.net:3306/fatmaa10_testclient");
        properties.setProperty("javax.persistence.jdbc.user","fatmaa10_testcli");
        properties.setProperty("javax.persistence.jdbc.password","aa11bb22cc33");

        return properties;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
