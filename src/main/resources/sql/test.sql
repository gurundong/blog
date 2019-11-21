CREATE 
	OR REPLACE VIEW product_item_price AS (
	SELECT
		a.* 
	FROM
		(
			(
			SELECT
				0 AS id,
				line.`code` AS product_line_code,
				line.`name` AS product_line_name,
				type.`code` AS product_type_code,
				type.`name` AS product_type_name,
				item.`code` AS item_code,
				item.`name` AS item_name,
				item.`status` AS item_status,
				item.prompt AS item_description,
				itemvalue.value_type AS item_type,
				itemvalue.value_text AS item_value,
				dict.item_value AS item_unit,
				version.version,
				version.version_name,
				version.effect_time,
				version.expire_time,
				version.remark AS version_description,
				factor.`code` AS factor_code,
				factor.`name` AS factor_name,
				factor.prompt AS factor_description,
				version.factor_property,
				price.price_factor,
				factorvalue.value_type AS price_factor_type,
				factorvalue.value_text AS price_factor_value,
				price.conversion_type,
				price.price_type,
				price.price_duration,
				price.price 
			FROM
				product_price AS price
				LEFT JOIN product_type AS type ON type.id = price.product_type_id
				LEFT JOIN product_price_version AS version ON version.version = price.price_version
				LEFT JOIN product_item AS item ON item.id = price.item_id
				LEFT JOIN product_line AS line ON line.id = type.product_line_id
				LEFT JOIN product_dict_item AS dict ON dict.item_id = price.unit 
				AND dict.group_id = 'product_item_unit'
				LEFT JOIN product_item_value AS itemvalue ON itemvalue.product_id = type.id 
				AND itemvalue.item_id = item.id 
				AND itemvalue.is_sku = 'N'
				LEFT JOIN product_item AS factor ON factor.id IN ( SELECT item_id FROM product_item_define WHERE product_type_id = type.id AND product_item_type = 'impactFactor' )
				LEFT JOIN product_item_value AS factorvalue ON factorvalue.product_id = type.id 
				AND factorvalue.item_id = factor.id 
				AND factorvalue.is_sku = 'N' 
				AND price.price_factor LIKE CONCAT( '%', SUBSTRING_INDEX( SUBSTRING_INDEX( factorvalue.value_text, '"value":"', - 1 ), '"', 1 ), '%' ) 
			ORDER BY
				line.id,
				type.id,
				item.id,
				version,
				factor.id 
			) UNION
			(
			SELECT
				0 AS id,
				line.`code` AS product_line_code,
				line.`name` AS product_line_name,
				type.`code` AS product_type_code,
				type.`name` AS product_type_name,
				item.`code` AS item_code,
				item.`name` AS item_name,
				item.`status` AS item_status,
				item.prompt AS item_description,
				itemvalue.value_type AS item_type,
				itemvalue.value_text AS item_value,
				'' AS item_unit,
				'' AS version,
				'' AS version_name,
				'' AS effect_time,
				'' AS expire_time,
				'' AS version_description,
				'' AS factor_code,
				'' AS factor_name,
				'' AS factor_description,
				'' AS factor_property,
				'' AS price_factor,
				'' AS price_factor_type,
				'' AS price_factor_value,
				'' AS conversion_type,
				'' AS price_type,
				'' AS price_duration,
				'' AS price 
			FROM
				product_item_value AS itemvalue
				LEFT JOIN product_type AS type ON type.id = itemvalue.product_id
				LEFT JOIN product_line AS line ON line.id = type.product_line_id
				LEFT JOIN product_item AS item ON item.id = itemvalue.item_id 
			WHERE
				itemvalue.item_id IN ( SELECT id FROM product_item WHERE `code` LIKE 'image_%' ) 
				AND itemvalue.product_id IN ( SELECT product_type_id FROM product_item_define WHERE product_item_type = 'other' ) 
				AND itemvalue.is_sku = 'N' 
			) 
		) AS a 
	);