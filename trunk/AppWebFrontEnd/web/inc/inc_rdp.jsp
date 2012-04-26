<br/>Desenvolvido por Alunos ADS UNATEC - Barro Preto<br/><br/>
<div class="modalTrocas" id="cxTrocas">
    <a href="#" class="btnFecharModal">Fechar</a>
    <hr>
    <ul>
    </ul>
</div>

<div class="modalTenho" id="cxEstadoJogo">
    <ul>
        <li>Selecione o que melhor descreve sua vontade neste jogo:<br/>
            <label><input name="rbNivel" type="radio" title="Jogo disponível apenas para exibição" value="1" /> Somente Exibição</label><br/>
            <label><input name="rbNivel" type="radio" title="Quero trocar de qualquer jeito" value="0" /> Oferta de Troca</label><br/><br/></li>
        <li style="height: 35px;"><label>Mídia: </label>
            <div id="stars-wrapper1">
                <input name="rbStarMidia" type="radio" title="Péssimo" value="1" />
                <input name="rbStarMidia" type="radio" title="Ruim" value="2" />
                <input name="rbStarMidia" type="radio" title="Regular" value="3" />
                <input name="rbStarMidia" type="radio" title="Bom" value="4" checked="checked" />
                <input name="rbStarMidia" type="radio" title="Muito Bom" value="5" />
                <input name="rbStarMidia" type="radio" title="Ótimo" value="6" />
                <input name="rbStarMidia" type="radio" title="Exelente" value="7"/>
            </div><span style="margin-left: 10px;" id="stars1-cap"></span>
            <dir class="cb"></dir>
        </li>
        <li style="height: 35px;"><label>Manual: </label>
            <div id="stars-wrapper2">
                <input name="rbStarManual" type="radio" title="Péssimo" value="1" />
                <input name="rbStarManual" type="radio" title="Ruim" value="2" />
                <input name="rbStarManual" type="radio" title="Regular" value="3" />
                <input name="rbStarManual" type="radio" title="Bom" value="4" checked="checked" />
                <input name="rbStarManual" type="radio" title="Muito Bom" value="5" />
                <input name="rbStarManual" type="radio" title="Ótimo" value="6" />
                <input name="rbStarManual" type="radio" title="Exelente" value="7"/>
            </div><span style="margin-left: 10px;" id="stars2-cap"></span>
            <dir class="cb"></dir>
        </li>
        <li style="height: 35px;"><label>Caixa/Capa: </label>
            <div id="stars-wrapper3">
                <input name="rbStarCaixa" type="radio" title="Péssimo" value="1" />
                <input name="rbStarCaixa" type="radio" title="Ruim" value="2" />
                <input name="rbStarCaixa" type="radio" title="Regular" value="3" />
                <input name="rbStarCaixa" type="radio" title="Bom" value="4" checked="checked" />
                <input name="rbStarCaixa" type="radio" title="Muito Bom" value="5" />
                <input name="rbStarCaixa" type="radio" title="Ótimo" value="6" />
                <input name="rbStarCaixa" type="radio" title="Exelente" value="7"/>
            </div><span style="margin-left: 10px;" id="stars3-cap"></span>
            <dir class="cb"></dir>
        </li>
        <li><br/>Regição:
            <select name="ddlRegiao" id="ddlRegiao">
                <option value="0">Escolha</option>
                <option value="1">América (R1)</option>
                <option value="2">Europa (R2)</option>
                <option value="3">Ásia (R3)</option>
            </select><br/><br/>
        </li>
        <li>Estado físico do jogo:<br/>
            <textarea name="txtDescricao" rows="5" cols="54" id="txtDescricao"></textarea>
        </li>
    </ul>
    <hr>
    <a id="btnTenhoSalvar" href="javascript:void(0);">Salvar</a> <a id="btnTenhoExcluir" href="javascript:void(0);">Excluir da Lista</a> <a href="#" class="btnFecharModal">Cancelar</a>
</div>