
* Source Repo: <https://github.com/{{site.repo}}>

## Documentation

* [Storybook](storybook)

## Open Pull Requests

<style>
table, th, td {
  border: 1px solid black;
  padding: 2px;
  border-collapse: collapse;
}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>

<table>
<thead>
<tr>
<th>PR</th>
<th>Branch</th>
<th>Author</th>
<th>Storybook</th>
</tr>
</thead>
<tbody>
{% for pr in site.pull_requests %}
<tr>
<td><a href="{{pr.url}}">PR {{pr.number}}</a></td>
<td>{{pr.headRefName}}</td>
<td>{{pr.author.login}}</td>
<td><a href="prs/{{pr.number}}/storybook">storybook</a></td>
</tr>
{% endfor %}
</tbody>
</table>