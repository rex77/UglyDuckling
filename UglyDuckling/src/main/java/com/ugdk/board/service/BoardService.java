package com.ugdk.board.service;

import java.util.List;

import com.ugdk.board.domain.BoardDTO;

public interface BoardService {

	public boolean registerBoard(BoardDTO params);

	public BoardDTO getBoardDetail(Long idx);

	public boolean deleteBoard(Long idx);

	public List<BoardDTO> getBoardList(BoardDTO params);
	
//	public List<BoardDTO> getPagedBoardList(int page); //rexa original
	
	public int updateViewCount(Long idx);
}
