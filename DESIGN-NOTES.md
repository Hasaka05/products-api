\# Design Notes



Modularity: I applied the Dependency Inversion Principle by making ProductService depend on the ProductRepository interface instead of a concrete implementation, as shown in ProductService.java and ProductRepository.java.



Testability: I can now inject a mock or fake ProductRepository into ProductService during testing to test service behaviour without relying on the actual storage implementation, which was not possible with the internally managed product list in Lecture 6.



The swap test: If the application moves to a database, I would replace InMemoryProductRepository with a JDBC-based ProductRepository implementation, while ProductService.java and ProductController.java would remain unchanged.

