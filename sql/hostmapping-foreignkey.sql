ALTER TABLE hostmapping
ADD FOREIGN KEY (hostname_id) REFERENCES hostname(hostname_id); 