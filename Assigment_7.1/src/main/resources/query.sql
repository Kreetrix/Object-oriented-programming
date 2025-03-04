USE currency_converter;

SELECT * FROM currencies;

SELECT * FROM currencies WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS total_currencies FROM currencies;

SELECT * FROM currencies ORDER BY conversion_rate DESC LIMIT 1;