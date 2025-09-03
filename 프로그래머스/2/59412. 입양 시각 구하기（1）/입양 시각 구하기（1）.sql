WITH RECURSIVE hours AS (
    SELECT 9 AS hour
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 19
)
    

SELECT h.hour AS HOUR, COUNT(ao.DATETIME) AS COUNT
FROM hours h
LEFT JOIN ANIMAL_OUTS ao ON h.hour = HOUR(ao.DATETIME)
GROUP BY h.hour
ORDER BY h.hour ASC;
