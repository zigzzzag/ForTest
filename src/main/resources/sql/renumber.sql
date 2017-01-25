MERGE INTO table1 a
  USING (SELECT
           t.id,
           (ROW_NUMBER() OVER (PARTITION BY t.t1 ORDER BY t.t2) - 1) new_index
         FROM
           table1 t
         WHERE t.t1 IN (SELECT value1 FROM table3)) b
  ON (a.id = b.id)
  WHEN MATCHED
  THEN UPDATE SET
    a.index = b.new_index;