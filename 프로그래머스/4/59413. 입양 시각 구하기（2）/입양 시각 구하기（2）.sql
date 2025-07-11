WITH RECURSIVE hours AS(
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 23
)

SELECT ho.hour AS HOUR, COUNT(ao.DATETIME) AS COUNT
FROM hours ho
LEFT JOIN ANIMAL_OUTS ao ON ho.hour = HOUR(ao.DATETIME)
GROUP BY ho.hour
ORDER BY ho.hour ASC;