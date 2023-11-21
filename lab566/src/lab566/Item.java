/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab566;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
/**
 *slide 30
 * @author HP
 */
@Entity
@Table(name="Item")
public class Item implements Serializable {
            @Id
            @Column(name=" itemName");
          private String ItemName;
          
           @Column(name=" itemQuantity");
               private  int Quantity;
               
                @Column(name=" quantityUnit");
            private String QuantityUnit; 
            
             @Column(name=" itemCategory");
           private  String Category ;
           
            @Column(name=" expiryDate");
            private String ExpiryDate;
            
            public Item() {}
            
                public Item(int Quantity) {
                this.Quantity = Quantity; 
                }
                
                public Item(String   ItemName,String QuantityUnit,String Category,String ExpiryDate) {
                this. Category=Category; 
                this.ItemName=ItemName;
                this.QuantityUnit=QuantityUnit;
                this.ExpiryDate=ExpiryDate;
                }

                public String getItemName() {
                    return ItemName;
                }

                public void setItemName(String ItemName) {
                    this.ItemName = ItemName;
                }

                public int getQuantity() {
                    return Quantity;
                }

                public void setQuantity(int Quantity) {
                    this.Quantity = Quantity;
                }

                public String getQuantityUnit() {
                    return QuantityUnit;
                }

                public void setQuantityUnit(String QuantityUnit) {
                    this.QuantityUnit = QuantityUnit;
                }

                public String getCategory() {
                    return Category;
                }

                public void setCategory(String Category) {
                    this.Category = Category;
                }

                public String getExpiryDate() {
                    return ExpiryDate;
                }

                public void setExpiryDate(String ExpiryDate) {
                    this.ExpiryDate = ExpiryDate;
                }

       }

