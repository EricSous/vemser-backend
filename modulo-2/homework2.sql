-- usei a propria formata��o do dbeaver ctrl + shift + f

SELECT * FROM VEM_SER.PAIS p ORDER BY NOME DESC;

SELECT
	LOGRADOURO,
	CEP
FROM
	ENDERECO e
WHERE
	UPPER(LOGRADOURO)
 LIKE '%A%';

SELECT
	*
FROM
	ENDERECO e
WHERE
	TRIM(CEP) LIKE '%0';

SELECT
	*
FROM
	ENDERECO e
WHERE
	NUMERO <= 100
	AND NUMERO >= 1;

SELECT
	*
FROM
	ENDERECO e
WHERE
	UPPER(LOGRADOURO) 
LIKE 'RUA%'
ORDER BY
	CEP DESC;

SELECT
	COUNT(ID_ENDERECO)
FROM
	ENDERECO e ;

SELECT
	COUNT(ID_ENDERECO)
FROM
	ENDERECO e
GROUP BY
	ID_CIDADE ;

SELECT * FROM JOGADOR WHERE NOME_JOGADOR = 'Jo�ozito'

