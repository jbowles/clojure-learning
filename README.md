# cloj-learning
Learn me some clojure

## Handy Reference Types Table
I ripped off the following table from [R. Mark Volkman](http://java.ociweb.com/mark/clojure/article.html#ReferenceTypes); his tutorial is by far the most comprehensive and up-to-date free clojure tutorial I have found yet. Bravo.

 <table border="1" style="font-size:8pt; width:100%">
      <tr>
        <th colspan="1" rowspan="1" style="width:8%"/>
        <th colspan="1" rowspan="1" style="width:23%">Var</th>
        <th colspan="1" rowspan="1" style="width:23%">Ref</th>
        <th colspan="1" rowspan="1" style="width:23%">Atom</th>
        <th colspan="1" rowspan="1" style="width:23%">Agent</th>
      </tr>
      <tr style="vertical-align:top">
        <th colspan="1" rowspan="1" style="text-align:left">Purpose</th>
        <td colspan="1" rowspan="1">synchronous changes<br />to a single, thread-local value</td>
        <td colspan="1" rowspan="1">synchronous, coordinated changes<br />to one or more values</td>
        <td colspan="1" rowspan="1">synchronous changes<br />to a single value</td>
        <td colspan="1" rowspan="1">asynchronous changes<br />to a single value</td>
      </tr>
      <tr style="vertical-align:top">
        <th colspan="1" rowspan="1" style="text-align:left">To create</th>
        <td colspan="1" rowspan="1">
          <code>(def <i>name</i> <i>initial-value</i>)</code>
        </td>
        <td colspan="1" rowspan="1">
          <code>(ref <i>initial-value</i>)</code>
        </td>
        <td colspan="1" rowspan="1">
          <code>(atom <i>initial-value</i>)</code>
        </td>
        <td colspan="1" rowspan="1">
          <code>(agent <i>initial-value</i>)</code>
        </td>
      </tr>
      <tr style="vertical-align:top">
        <th colspan="1" rowspan="1" style="text-align:left">To modify</th>
        <td colspan="1" rowspan="1">
          <code>(def <i>name</i> <i>new-value</i>)</code>
<br />
          sets new root value
          <hr />
          <code>(alter-var-root<br />
            (var <i>name</i>) <i>update-fn</i> <i>args</i>)</code>
<br />
          atomically sets new root value
          <hr />
          <code>(set! <i>name</i> <i>new-value</i>)</code>
<br />
          sets new, thread-local value
          inside a <code>binding</code> form
        </td>
        <td colspan="1" rowspan="1">
          <code>(ref-set <i>ref</i> <i>new-value</i>)</code>
<br />
          must be inside a <code>dosync</code>
<br />
          <hr />
          <code>(alter <i>ref</i>
<br />
            <i>update-fn</i> <i>arguments</i>)</code>
<br />
          must be inside a <code>dosync</code>
<br />
          <hr />
          <code>(commute <i>ref</i>
<br />
            <i>update-fn</i> <i>arguments</i>)</code>
<br />
          must be inside a <code>dosync</code>
        </td>
        <td colspan="1" rowspan="1">
          <code>(reset! <i>atom</i> <i>new-value</i>)</code>
<br />
          <hr />
          <code>(compare-and-set! <i>atom</i> <i>current-value</i> <i>new-value</i>)</code>
<br />
          <hr />
          <code>(swap! <i>atom</i>
<br />
            <i>update-fn</i> <i>arguments</i>)</code>
        </td>
        <td colspan="1" rowspan="1">
          <code>(send <i>agent</i>
<br />
            <i>update-fn</i> <i>arguments</i>)</code>
<br />
          <hr />
          <code>(send-off <i>agent</i>
<br />
            <i>update-fn</i> <i>arguments</i>)</code>
        </td>
      </tr>
 </table>

## Usage

FIXME: write

## License

Copyright (C) 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
