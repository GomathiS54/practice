package com.example.demo.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraResponse {

	private List<Issue> issues;

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Issue {
		private Long id;
		private String key;
		private Fields fields;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Fields getFields() {
			return fields;
		}

		public void setFields(Fields fields) {
			this.fields = fields;
		}

		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Fields {
			private String summary;
			private String description;
			private Creator creator;
			private String created;

			public String getSummary() {
				return summary;
			}

			public void setSummary(String summary) {
				this.summary = summary;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public Creator getCreator() {
				return creator;
			}

			public void setCreator(Creator creator) {
				this.creator = creator;
			}

			public String getCreated() {
				return created;
			}

			public void setCreated(String created) {
				this.created = created;
			}

			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class Creator {
				private String displayName;

				public String getDisplayName() {
					return displayName;
				}

				public void setDisplayName(String displayName) {
					this.displayName = displayName;
				}
			}
		}
	}
}
