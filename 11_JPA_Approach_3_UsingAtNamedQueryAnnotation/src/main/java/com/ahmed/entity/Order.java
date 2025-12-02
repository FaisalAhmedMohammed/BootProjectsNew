package com.ahmed.entity;

import java.time.LocalDate;
/*@named query annotation we have to use it for jpql queries not for sql query
  This annotation can be used to define a named query that can be reused across multiple places in our application.
It is recommended to start with entity class name and some method name.
  Named query improves the query readability as the query and entity class used in the query are at one place.
•	Query name and the method name should match then while creating implementation
 class jpa will execute this method, here which query should execute jpa will 
 retrieve the query based on method name and will return entity class object 

Q) Why it should start with entity name?
 

•	Here I am not following the naming convention they have different entity class one customer and another is order 
•	But both the method names are same 
•	The naming convention to be followed to provide a name to the query is 
“entityclassname.methodname”
•	JPA will store the named queries in PeristenceContext object, with their 
names. If multiple queries are configured with the same name, then one query 
will override another query.
•	So, it is recommended to name the query with naming convention
 

•	Here, the two queries have the same name. So, one query will override another.

  We define a named query at entity level and it is referred in the repository, with its name.
  Without rewriting a query, it can be used at different parts of the application.
  Named queries are pre compiled by the JPA provider. So, it improves performance.
  Like @NamedQuery, we also have @NamedNativeQuery to configure native SQL query at entity level.
•	we can define multiple @NamedQuery’s or @NamedNativeQuery’s at entity class level.
*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "neworders")

// it makes query more readable because entity class and query is at one place
@NamedQuery(
    name = "Order.findAllOrders",
    query = "SELECT o FROM Order o"
)
@NamedNativeQuery(
    name = "Order.getAllOrders",
    query = "SELECT * FROM neworders",
    resultClass = Order.class
)
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "DATE_PURCHASED")
    private LocalDate datePurchased;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;
}
