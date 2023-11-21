/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab566;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author HP
 */
public class HibernateUtil {
        private static final SessionFactory sessionFactory;
            static {
                     try {
                        // loads configuration and mappings (change ways)
                        Configuration configuration =new Configuration().configure("/warehouseInventory/hibernate.cfg.xml");
                        
                        ServiceRegistry serviceRegistry= new
                        StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                        //change name of class
                        configuration.addAnnotatedClass(Item.class);
                        
                        // builds a session factory from the service registry
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
                    } catch (Throwable ex) { // Log the exception.
                    System.err.println("Initial SessionFactory creation failed." + ex); 
                    throw new ExceptionInInitializerError(ex);
                    }
                }
            
            public static SessionFactory getSessionFactory() {
                return sessionFactory;
            }
        }
