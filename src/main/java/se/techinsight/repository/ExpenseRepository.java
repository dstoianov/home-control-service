package se.techinsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.techinsight.model.Category;
import se.techinsight.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
