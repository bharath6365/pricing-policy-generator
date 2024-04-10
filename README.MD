## Project Overview
The project is organized as a multi-module Maven project focused on delivering dynamic pricing engine capabilities. You can try it out here https://avid-bells-production.up.railway.app/

It comprises three principal modules:

`pricing-common`: This module houses shared entities, utilities, and configurations that are utilized across the entire project. This includes domain models such as Customer, Pricing, Rule, and possibly shared utilities for handling data manipulation or inter-module communication.

`pricing-server`: Responsible for providing web service access to the pricing engine's functionalities. This module likely includes controllers for managing HTTP requests, services for implementing business logic, and integration with the pricing-engine to perform rule evaluations.

`pricing-engine`: Contains the core logic for the evaluation of pricing rules. It employs DSL (Domain-Specific Language) parsing and MVEL (MVFLEX Expression Language) to dynamically evaluate rules based on the provided input data.

### MVEL and DSL Parser
#### MVEL (MVFLEX Expression Language)
MVEL is an expression language for Java-based applications that enables dynamic execution of scripts, expressions, and templates. Within this project, MVEL is used for evaluating the conditions and actions defined in pricing rules, offering flexibility and dynamic capabilities, enabling complex logic assessment at runtime without the need for recompilation.
https://mvel.documentnode.com/

#### DSL Parser
The DSL (Domain-Specific Language) parser is designed to interpret and convert custom language expressions into a format that the system can understand and process. For this project, the DSL parser likely translates domain-specific expressions into MVEL expressions or directly executable Java code, allowing for a more intuitive and readable definition of pricing rules, which can then be dynamically parsed and executed by the engine.

### Multi-Maven Project Support
This project is structured as a multi-module Maven project, which is a standard pattern for separating concerns and promoting modularity in Java applications. Maven allows a parent project to include submodules, each capable of independently managing its dependencies, build configurations, and artifacts, while sharing common configurations from the parent POM (Project Object Model) file. The modules included are:

pricing-common
pricing-server
pricing-engine

### Rule Evaluation Process
The process of rule evaluation in the pricing engine involves iterating over each rule to dynamically determine its applicability based on the input data:

`DSL Parsing`: The first step involves parsing and resolving any DSL expressions within a rule. This step is crucial for transforming custom DSL syntax into executable logic or MVEL expressions, preparing the rule for evaluation.

`MVEL Evaluation`: Following DSL resolution, the engine uses MVEL to evaluate the rule's condition against the current context (e.g., customer data). If the condition is met (true), the engine executes the rule's defined action.

Iterating Over Rules: The engine systematically processes each rule, applying DSL parsing followed by MVEL evaluation, to dynamically adjust pricing based on the defined conditions and actions.

This structured approach enables dynamic pricing adjustments through an intuitive rule definition and efficient evaluation process.

### Important Attributes in Rule Model

#### Conditions
Condition: This is a logical expression evaluated to determine whether the rule's action should be executed. The condition assesses the input data against specific criteria.

Example 1: $(bank).target_done == true || $(bank).under_maintenance == true
This condition uses a Domain-Specific Language (DSL) to check if the bank has reached its target loan issuance or is currently under maintenance. The $(...) syntax denotes a DSL expression that needs to be parsed into a condition understandable by the system.
Example 2: input.getMonthlyIncome() < 10000
This condition directly uses the input data to check if the monthly income of the loan applicant is less than 10,000. It's a straightforward condition that doesn't require DSL parsing.

#### Actions
Actions are operations executed when the condition of a rule is met. They modify the output, which in this case is the pricing decision.

Example 1 Action: output.setApprovalStatus(false); output.setRejectionReason("Lender at full capacity");
If the bank has reached its lending target or is under maintenance, this action sets the loan approval status to false and specifies the rejection reason as "Lender at full capacity."
Example 2 Action: output.setApprovalStatus(false); output.setRejectionReason("Income not enough");
If the applicant's monthly income is less than 10,000, the loan approval status is set to false with the rejection reason "Income not enough."

#### DSL (Domain-Specific Language)
 A DSL is a specialized language tailored to a specific domain. In the context of these rules, DSL expressions like $(bank).target_done provide a readable and succinct way to access complex logic or external conditions that aren't directly part of the applicant's input data. DSL expressions need to be parsed and interpreted to assess the rule's condition.

#### Terminal Rule
A terminal rule is one that, when its condition is met and action executed, prevents the evaluation of any subsequent rules. This is typically used for rules that make definitive decisions.

In both examples, the terminal rule is marked "Yes," indicating that if either rule's condition is met, the evaluation process should not continue further. This makes sense in these contexts, as both conditions represent definitive reasons to reject a loan application.