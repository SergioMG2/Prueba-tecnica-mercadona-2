/*==============================================================*/
/* Table: topic_employee_skill                                  */
/*==============================================================*/

CREATE TABLE topic_employee_skill (
	employee_id varchar(7) NOT NULL,
	managed_group_id varchar(2) NOT NULL,
	skill_id INT NOT NULL,
	CONSTRAINT topic_employee_skill_pkey PRIMARY KEY (employee_id, managed_group_id, skill_id)
);

ALTER TABLE topic_employee_skill ADD CONSTRAINT topic_employee_skill_id_fkey FOREIGN KEY (skill_id) REFERENCES topic_skill(skill_id);
