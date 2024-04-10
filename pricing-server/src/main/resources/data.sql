INSERT INTO rules
(id, action, condition, description, is_terminal, namespace, rule_type)
VALUES
    (1, 'output.setApprovalStatus(false); output.setRejectionReason("Lender at full capacity");', '$(bank).target_done == true || $(bank).under_maintenance == true', 'Lender at full capacity', true, 'PersonalLoan', 0),
    (2, 'output.setApprovalStatus(false); output.setRejectionReason("Income not enough");', 'input.getMonthlyIncome() < 10000', 'Income not enough', true, 'PersonalLoan', 2),
    (3, 'output.setApprovalStatus(false); output.setRejectionReason("Age not enough");', 'input.getAge() < 18', 'Age not enough', true, 'PersonalLoan', 2),
    (4, 'output.setApprovalStatus(false); output.setRejectionReason("Age exceeds limit");', 'input.getAge() > 60', 'Age exceeds limit', true, 'PersonalLoan', 2),
    (5, 'output.setApprovalStatus(false); output.setRejectionReason("Must be earning");', 'input.getEmploymentType().toString() == "RETIRED" || input.getEmploymentType().toString() == "STUDENT"', 'Must be earning', true, 'PersonalLoan', 2),
    (6, 'output.setApprovalStatus(false); output.setRejectionReason("CIBIL score too low");', 'input.getCibilScore() < 200', 'CIBIL score too low', true, 'PersonalLoan', 2),
    (7, 'output.setApprovalStatus(true); output.setPrincipal(12*input.getMonthlyIncome()); output.setTenureInMonths(12); output.setProcessingFee(12); output.setInterestRate(10.5);', 'input.getCibilScore() < 300 || input.getMonthlyIncome() < 30000', 'Low tier risk assessment', false, 'PersonalLoan', 1),
    (8, 'output.setApprovalStatus(true); output.setPrincipal(24*input.getMonthlyIncome()); output.setTenureInMonths(18); output.setProcessingFee(10); output.setInterestRate(8.5);', 'input.getCibilScore() >= 300 && input.getCibilScore() < 600 || input.getMonthlyIncome() >= 30000 && input.getMonthlyIncome() < 100000', 'Mid tier risk assessment', false, 'PersonalLoan', 1),
    (9, 'output.setApprovalStatus(true); output.setPrincipal(36*input.getMonthlyIncome()); output.setTenureInMonths(24); output.setProcessingFee(8); output.setInterestRate(6.5);', 'input.getCibilScore() > 600 || input.getMonthlyIncome() > 100000', 'High tier risk assessment', false, 'PersonalLoan', 1),
    (10, 'output.setFirstEmiDate(5);', 'true', 'Default action for approval', false, 'PersonalLoan', 1),
    (11, 'output.setForeClosureCharges(10);', 'true', 'Default action for approval', false, 'PersonalLoan', 1);
