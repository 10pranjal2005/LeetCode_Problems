DELETE p1 FROM Person AS p1
LEFT JOIN (
  SELECT MIN(id) AS id, email
  FROM Person
  GROUP BY email
) AS p2
ON p1.email = p2.email AND p1.id = p2.id
WHERE p2.id IS NULL;

